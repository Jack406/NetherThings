package com.brand.netherthings.items;

import com.brand.netherthings.NetherThings;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Vibranium {

	public static final Item VIBRANIUM = register("vibranium", new Item(new Item.Settings().stackSize(1).itemGroup(ItemGroup.MISC)));

	public static Item register(String name, Item item) {
	    return Registry.register(Registry.ITEM, new Identifier(NetherThings.MOD_ID, name), item);
	}
}