package dev.hybridlabs.aquatic.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.client.render.WorldRenderer.getLightmapCoordinates;

@Mixin(WorldRenderer.class)
public abstract class WeatherDisplayMixin implements SynchronousResourceReloader, AutoCloseable {

    @Unique
    private static final Identifier MARINE_SNOW = new Identifier("hybrid-aquatic","textures/environment/marine_snow.png");

//    @Inject(method = "renderWeather", at=@At(value = "INVOKE", target = "Lnet/minecraft/client/render/BufferBuilder;begin(Lnet/minecraft/client/render/VertexFormat$DrawMode;Lnet/minecraft/client/render/VertexFormat;)V"))
//    void hybrid$renderWeather(LightmapTextureManager manager, float tickDelta, double cameraX, double cameraY, double cameraZ, CallbackInfo ci) {
//        RenderSystem.setShaderTexture(0, MARINE_SNOW);
//        System.out.println("foo");
//    }

    @Shadow private int ticks;
    @Final @Shadow private float[] NORMAL_LINE_DX;
    @Final @Shadow private float[] NORMAL_LINE_DZ;
    @Final @Shadow private MinecraftClient client;

    @Inject(method = "renderWeather", at=@At("HEAD"))
    void hybrid$renderWeatherInject(LightmapTextureManager manager, float tickDelta, double cameraX, double cameraY, double cameraZ, CallbackInfo ci) {
        if(client.player != null && client.world != null) {
            float f = this.client.world.getRainGradient(tickDelta);
            World world = this.client.world;
            if (f > 0.0f && cameraY < world.getSeaLevel() - 16.0 && world.getBiome(client.player.getBlockPos()).isIn(BiomeTags.IS_DEEP_OCEAN)) {
                manager.enable();
                int xFloored = MathHelper.floor(cameraX);
                int yFloored = MathHelper.floor(cameraY);
                int zFloored = MathHelper.floor(cameraZ);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuffer();
                RenderSystem.disableCull();
                RenderSystem.enableBlend();
                RenderSystem.enableDepthTest();
                int layers = 5;
                if (MinecraftClient.isFancyGraphicsOrBetter()) {
                    layers = 10;
                }

                RenderSystem.depthMask(MinecraftClient.isFabulousGraphicsOrBetter());
                int m = -1;
                RenderSystem.setShader(GameRenderer::getParticleProgram);
                BlockPos.Mutable mutable = new BlockPos.Mutable();

                for (int n = zFloored - layers; n <= zFloored + layers; ++n) {
                    for (int o = xFloored - layers; o <= xFloored + layers; ++o) {
                        int p = (n - zFloored + 16) * 32 + o - xFloored + 16;
                        double d = (double) this.NORMAL_LINE_DX[p] * 0.5;
                        double e = (double) this.NORMAL_LINE_DZ[p] * 0.5;
                        mutable.set(o, cameraY, n);
                        Biome biome = world.getBiome(mutable).value();
                        if (biome.hasPrecipitation()) {
                            int height = world.getTopY(Heightmap.Type.OCEAN_FLOOR, o, n);
                            int r = yFloored - layers;
                            int s = yFloored + layers;
                            if (r < height) {
                                r = height;
                            }

                            if (s < height) {
                                s = height;
                            }

                            int t = Math.max(height, yFloored);

                            if (r != s) {
                                Random random = Random.create(((long) o * o * 3121 + o * 45238971L ^ (long) n * n * 418711 + n * 13761L));
                                mutable.set(o, r, n);
                                Biome.Precipitation precipitation = biome.getPrecipitation(mutable);
                                float h;
                                float y;
                                if (precipitation == Biome.Precipitation.RAIN) {
                                    if (m != 0) {
                                        if (m >= 0) {
                                            tessellator.draw();
                                        }

                                        m = 0;
                                        RenderSystem.setShaderTexture(0, MARINE_SNOW);
                                        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
                                    }

                                    int u = this.ticks + o * o * 3121 + o * 45238971 + n * n * 418711 + n * 13761 & 31;
                                    h = -((float) u + tickDelta) / 512.0F * (3.0F + random.nextFloat());
                                    double v = (double) o + 1.0 - cameraX;
                                    double w = (double) n + 1.0 - cameraZ;
                                    float x = (float) Math.sqrt(v * v + w * w) / (float) layers;
                                    y = ((1.0F - x * x) * 0.5F + 0.5F) * f;
                                    mutable.set(o, t, n);
                                    int z = getLightmapCoordinates(world, mutable);

                                    float seaLevelDist = Math.max(0.0f, (float) (world.getSeaLevel() - cameraY) / 128.0f);
                                    float lerpedAlpha = MathHelper.lerp(seaLevelDist, 0.0f, 1.0f);
                                    float clampedAlpha = MathHelper.clamp(y - lerpedAlpha, 0.0f, 1.0f);

                                    bufferBuilder.vertex((double) o - cameraX - d + 0.5, (double) s - cameraY, (double) n - cameraZ - e + 0.5).texture(0.0F, (float) r * 0.25F + h).color(1.0F, 1.0F, 1.0F, clampedAlpha * f).light(z).next();
                                    bufferBuilder.vertex((double) o - cameraX + d + 0.5, (double) s - cameraY, (double) n - cameraZ + e + 0.5).texture(1.0F, (float) r * 0.25F + h).color(1.0F, 1.0F, 1.0F, clampedAlpha * f).light(z).next();
                                    bufferBuilder.vertex((double) o - cameraX + d + 0.5, (double) r - cameraY, (double) n - cameraZ + e + 0.5).texture(1.0F, (float) s * 0.25F + h).color(1.0F, 1.0F, 1.0F, clampedAlpha * f).light(z).next();
                                    bufferBuilder.vertex((double) o - cameraX - d + 0.5, (double) r - cameraY, (double) n - cameraZ - e + 0.5).texture(0.0F, (float) s * 0.25F + h).color(1.0F, 1.0F, 1.0F, clampedAlpha * f).light(z).next();
                                }
                            }
                        }
                    }
                }

                if (m >= 0) {
                    tessellator.draw();
                }

                RenderSystem.enableCull();
                RenderSystem.disableBlend();
                manager.disable();
            }
        }
    }
}
