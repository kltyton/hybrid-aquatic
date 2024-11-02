package dev.hybridlabs.aquatic.command

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import dev.hybridlabs.aquatic.HybridAquatic
import net.minecraft.registry.Registries
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text

object RandomFishCommand {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>) {
        dispatcher.register(
            CommandManager.literal("randomhybridfish")
                .requires { it.hasPermissionLevel(2) }
                .executes(::execute)
        )
    }

    private fun execute(context: CommandContext<ServerCommandSource>): Int {
        val types = Registries.ENTITY_TYPE.filter { type ->
            val id = Registries.ENTITY_TYPE.getId(type)
            id.namespace == HybridAquatic.MOD_ID
        }

        types.randomOrNull()?.also { type ->
            val name = type.name
            context.source.sendFeedback({ Text.literal("Fishy time! ").append(name) }, false)
        }

        return 1
    }
}
