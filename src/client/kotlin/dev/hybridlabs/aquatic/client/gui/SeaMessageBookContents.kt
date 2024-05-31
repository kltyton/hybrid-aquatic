package dev.hybridlabs.aquatic.client.gui

import dev.hybridlabs.aquatic.block.SeaMessage
import net.minecraft.client.gui.screen.ingame.BookScreen.Contents
import net.minecraft.client.resource.language.I18n
import net.minecraft.text.StringVisitable

/**
 * Custom book contents for Sea Message books.
 */
class SeaMessageBookContents(message: SeaMessage) : Contents {
    private val text = I18n.translate(message.translationKey)

    override fun getPageCount(): Int {
        return 1
    }

    override fun getPageUnchecked(index: Int): StringVisitable {
        return StringVisitable.plain(text)
    }
}
