package com.template

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLConstructionEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.registries.IForgeRegistry
import org.apache.logging.log4j.Logger

/*
    Kotlin用テンプレート
    やってることはTemplate.javaと同じ
*/
/*@Mod(
    modid = TemplateKotlin.MOD_ID,
    name = TemplateKotlin.MOD_NAME,
    version = TemplateKotlin.VERSION,
    acceptedMinecraftVersions = "[1.12, 1.12.2]"
)*/
object TemplateKotlin {

    const val MOD_ID: String = "template"
    const val MOD_NAME: String = "template"
    const val VERSION: String = "template"

    lateinit var LOGGER: Logger

    @Mod.EventHandler
    fun onConstruct(event: FMLConstructionEvent) {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @Mod.EventHandler
    fun onPreInit(event: FMLPreInitializationEvent) {
        LOGGER = event.modLog
        if (::LOGGER.isInitialized) LOGGER.info("Hello World!")
    }

    @SubscribeEvent
    fun registerBlock(event: RegistryEvent.Register<Block>) {
        val registry: IForgeRegistry<Block> = event.registry
    }

    @SubscribeEvent
    fun registerItem(event: RegistryEvent.Register<Item>) {
        val registry: IForgeRegistry<Item> = event.registry
    }

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {

    }

    @Mod.EventHandler
    fun onPostInit(event: FMLPostInitializationEvent) {

    }

}