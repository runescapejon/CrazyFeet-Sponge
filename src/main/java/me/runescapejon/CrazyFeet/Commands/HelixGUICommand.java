package me.runescapejon.CrazyFeet.Commands;

import java.util.Optional;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.item.inventory.property.SlotPos;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;

public class HelixGUICommand implements CommandExecutor {
	Inventory invs = Inventory.builder().of(InventoryArchetypes.CHEST)
			.property(InventoryDimension.PROPERTY_NAME, new InventoryDimension(9, 4))
			.property(InventoryTitle.PROPERTY_NAME,
					InventoryTitle.of(Text.builder("§bH§ee§al§ci§2x §cC§ao§el§eo§cr §eP§2i§dc§bk§2e§ar").build()))
			.build(CrazyFeet.getPlugin());

	@Listener
	public void onInventoryClick(ClickInventoryEvent event, @First Player player) {
		if (event.getTargetInventory().getName().get().equals(this.invs.getName().get())) {
			Transaction<ItemStackSnapshot> clickTransaction = event.getTransactions().get(0);
			ItemStack item = clickTransaction.getOriginal().createStack();
			if (item.getType().equals(ItemTypes.BOOK)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazymenu"))
						.submit(CrazyFeet.getInstance());
				event.setCancelled(true);
			}
			if (item.getType().equals(ItemTypes.BARRIER)) {
				player.playSound(SoundTypes.BLOCK_ANVIL_PLACE, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazydisable"))
						.submit(CrazyFeet.getInstance());
				event.setCancelled(true);
			}
			if (item.getType().equals(ItemTypes.REDSTONE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyredhelix"))
						.submit(CrazyFeet.getInstance());
				event.setCancelled(true);
			}
			Optional<DyeColor> optionalDyeColor = item.get(Keys.DYE_COLOR);
			if (!optionalDyeColor.isPresent()) {
				return;
			}
			DyeColor dyeColorpurple = optionalDyeColor.get();
			if (dyeColorpurple.equals(DyeColors.PURPLE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazypurplehelix"))
						.submit(CrazyFeet.getInstance());
			}
			DyeColor dyeColor = optionalDyeColor.get();
			if (dyeColor.equals(DyeColors.GREEN)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazygreenhelix"))
						.submit(CrazyFeet.getInstance());
			}

			DyeColor dyeColor1 = optionalDyeColor.get();
			if (dyeColor1.equals(DyeColors.WHITE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazywhitehelix"))
						.submit(CrazyFeet.getInstance());
			}
			DyeColor dyeColorblue = optionalDyeColor.get();
			if (dyeColorblue.equals(DyeColors.LIGHT_BLUE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazybluehelix"))
						.submit(CrazyFeet.getInstance());
			}
			DyeColor dyeColorYellow = optionalDyeColor.get();
			if (dyeColorYellow.equals(DyeColors.YELLOW)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyyellowhelix"))
						.submit(CrazyFeet.getInstance());
			}
			DyeColor dyeColorOrange = optionalDyeColor.get();
			if (dyeColorOrange.equals(DyeColors.ORANGE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyorangehelix"))
						.submit(CrazyFeet.getInstance());
			}

			DyeColor dyeColorBrown = optionalDyeColor.get();
			if (dyeColorBrown.equals(DyeColors.BROWN)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazybrownhelix"))
						.submit(CrazyFeet.getInstance());
			}

			event.setCancelled(true);
		}
	}

	// this will fix the bug that drop items off of guis
	@Listener
	public void DropEvent(ClickInventoryEvent.Drop event) {
		if (event.getTargetInventory().getName().get().equals(this.invs.getName().get())) {
			event.setCancelled(true);
		}
	}

	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext ctx) throws CommandException {
		Player player = (Player) src;
		ItemStack helixblue = ItemStack.of(ItemTypes.DYE, 1);
		helixblue.offer(Keys.DISPLAY_NAME, Text.of(TextColors.BLUE, "Crazy Blue Helix!"));
		helixblue.offer(Keys.DYE_COLOR, DyeColors.LIGHT_BLUE);
		ItemStack white = ItemStack.of(ItemTypes.DYE, 1);
		white.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, "Crazy White Helix!"));
		white.offer(Keys.DYE_COLOR, DyeColors.WHITE);

		ItemStack green = ItemStack.of(ItemTypes.DYE, 1);
		green.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GREEN, "Crazy Green Helix!"));
		green.offer(Keys.DYE_COLOR, DyeColors.GREEN);

		ItemStack red = ItemStack.of(ItemTypes.REDSTONE, 1);
		red.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "Crazy Red Helix!"));

		ItemStack purple = ItemStack.of(ItemTypes.DYE, 1);
		purple.offer(Keys.DISPLAY_NAME, Text.of(TextColors.LIGHT_PURPLE, "Crazy Purple Helix!"));
		purple.offer(Keys.DYE_COLOR, DyeColors.PURPLE);

		ItemStack yellow = ItemStack.of(ItemTypes.DYE, 1);
		yellow.offer(Keys.DISPLAY_NAME, Text.of(TextColors.YELLOW, "Crazy Yellow Helix!"));
		yellow.offer(Keys.DYE_COLOR, DyeColors.YELLOW);

		ItemStack orange = ItemStack.of(ItemTypes.DYE, 1);
		orange.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GOLD, "Crazy Orange Helix!"));
		orange.offer(Keys.DYE_COLOR, DyeColors.ORANGE);

		ItemStack brown = ItemStack.of(ItemTypes.DYE, 1);
		brown.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GRAY, "Crazy Brown Helix!"));
		brown.offer(Keys.DYE_COLOR, DyeColors.BROWN);

		ItemStack bordergray = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		bordergray.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("chooseParticleMode"));
		bordergray.offer(Keys.DYE_COLOR, DyeColors.GRAY);

		ItemStack borderred = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		borderred.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("chooseParticleMode"));
		borderred.offer(Keys.DYE_COLOR, DyeColors.RED);

		ItemStack borderblue = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		borderblue.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("chooseParticleMode"));
		borderblue.offer(Keys.DYE_COLOR, DyeColors.BLUE);

		ItemStack borderwhite = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		borderwhite.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("chooseParticleMode"));
		borderwhite.offer(Keys.DYE_COLOR, DyeColors.WHITE);

		ItemStack borderyellow = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		borderyellow.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("chooseParticleMode"));
		borderyellow.offer(Keys.DYE_COLOR, DyeColors.YELLOW);

		ItemStack borderpink = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		borderpink.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("chooseParticleMode"));
		borderpink.offer(Keys.DYE_COLOR, DyeColors.PINK);

		ItemStack bordergreen = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		bordergreen.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("chooseParticleMode"));
		bordergreen.offer(Keys.DYE_COLOR, DyeColors.GREEN);

		ItemStack borderpurple = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		borderpurple.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("chooseParticleMode"));
		borderpurple.offer(Keys.DYE_COLOR, DyeColors.LIGHT_BLUE);

		ItemStack cdisable = ItemStack.of(ItemTypes.BARRIER, 1);
		cdisable.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("removeAllParticles"));

		ItemStack menu = ItemStack.of(ItemTypes.BOOK, 1);
		menu.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("MainMenu"));

		player.openInventory(invs);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 0))).set(bordergreen);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 0))).set(borderred);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 0))).set(borderwhite);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 0))).set(borderpurple);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 0))).set(borderpink);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 0))).set(bordergray);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 0))).set(borderpink);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 0))).set(bordergreen);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 0))).set(borderred);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 3))).set(borderpurple);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 3))).set(borderwhite);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 3))).set(bordergreen);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 3))).set(borderred);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 3))).set(borderblue);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 3))).set(borderpurple);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 3))).set(borderwhite);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 3))).set(borderblue);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 1))).set(bordergray);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 1))).set(borderpink);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 1))).set(borderblue);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 2))).set(borderred);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 2))).set(borderpink);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 3))).set(cdisable);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 3))).set(menu);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 1))).set(helixblue);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 1))).set(white);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 1))).set(green);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 1))).set(red);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 1))).set(purple);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 1))).set(yellow);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 1))).set(orange);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 2))).set(brown);
		// invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 2)).set(fireH);
		// invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 2)).set(heartH);
		// invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 2)).set(noteH);
		// invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 2)).set(magicH);
		// invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 2)).set(witchH);
		// invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 2)).set(pearlH);
		// invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 2)).set(smokeh);
		player.sendMessage(LanguageUtils.getText("pleaseSelectCrazyParticle"));
		player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
		return CommandResult.success();
	}
}
