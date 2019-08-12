package com.brand.netherthings.blocks;


import java.util.Random;

import com.brand.netherthings.NetherThings;
import com.brand.netherthings.content.Ores;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class BlockOreDiamondP extends Block {
	
	
public BlockOreDiamondP(String name, float hardness, float resistance) {
	super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 3).strength(hardness, resistance).build());
	Registry.register(Registry.BLOCK, new Identifier(NetherThings.MOD_ID, name), this);
	Registry.register(Registry.ITEM,new Identifier(NetherThings.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(NetherThings.NETHER_THINGS_GROUP)));

    }

public BlockOreDiamondP(Block.Settings block$Settings_1) {
    super(block$Settings_1);
 }

 protected int getExperienceWhenMined(Random random_1) {
   if (this == Ores.VIBRANIUM_ORE) {
         return MathHelper.nextInt(random_1, 7, 14);
    } else {
	 return this == Ores.NETHER_VIBRANIUM_ORE ? MathHelper.nextInt(random_1, 7, 14) : 0;
    }
 }
 
 public void onStacksDropped(BlockState blockState_1, World world_1, BlockPos blockPos_1, ItemStack itemStack_1) {
    super.onStacksDropped(blockState_1, world_1, blockPos_1, itemStack_1);
    if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, itemStack_1) == 0) {
       int int_1 = this.getExperienceWhenMined(world_1.random);
       if (int_1 > 0) {
          this.dropExperience(world_1, blockPos_1, int_1);
       }    
    }
  }
}
