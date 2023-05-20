package com.template;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Template.MOD_ID,
        name = Template.MOD_NAME,
        version = Template.VERSION,
        acceptedMinecraftVersions = "[1.12, 1.12.2]"
)
public class Template {

    /*
        MODIDの宣言
        static宣言すると他のクラスからも参照できるようになる
        他modと重複しない値にしなければならない
    */
    public static final String MOD_ID = "template";

    /*
        MOD名の宣言
        static宣言すると他のクラスからも参照できるようになる
        表示にのみ使われる
    */
    public static final String MOD_NAME = "template";

    /*
        MODのバージョンの宣言
        static宣言すると他のクラスからも参照できるようになる
        表示にのみ使われる
    */
    public static final String VERSION = "0.0.0";

    /*
        LOGGERのバージョンの宣言
        static宣言すると他のクラスからも参照できるようになる
        logファイルに値を出力するのに使われる
        onPreInit()内で初期化するため，値は不要
    */
    public static Logger LOGGER;

    /*
        Construct段階で呼び出されるメソッド
        ここでEventの登録をしておくと楽
    */
    @Mod.EventHandler
    public void onConstruct(FMLConstructionEvent event) {
        //このクラス自体をEventに登録
        MinecraftForge.EVENT_BUS.register(this);
    }

    /*
        PreInitialization段階で呼び出されるメソッド
        LoggerやConfigフォルダの階層を取得できる
        BlockやItemインスタンスの生成はここまでに行う
    */
    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        //LOGGERの初期化
        LOGGER = event.getModLog();
        //LOGGERが取得できなかった場合に備えてnullチェックを行う
        if (LOGGER != null) {
            LOGGER.info("Hello World!");
        }
    }

    /*
        Blockの登録を行うメソッド
        @SubscribeEventをつけることでEventとして処理される
    */
    @SubscribeEvent
    public void registerBlock(RegistryEvent.Register<Block> event) {
        //eventからレジストリを取得
        IForgeRegistry<Block> registry = event.getRegistry();
        //Blockをレジストリに登録する
        //registry.register();
    }

    /*
        Itemの登録を行うメソッド
        @SubscribeEventをつけることでEventとして処理される
    */
    @SubscribeEvent
    public void registerItem(RegistryEvent.Register<Item> event) {
        //eventからレジストリを取得
        IForgeRegistry<Item> registry = event.getRegistry();
        //Itemをレジストリに登録する
        //registry.register();
    }

    /*
        Initialization段階で呼び出されるメソッド
        OreDictionaryやレシピの登録を行う
    */
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {

    }

    /*
        PostInitialization段階で呼び出されるメソッド
        他modとの連携の登録を行う
    */
    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {

    }

}