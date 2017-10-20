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
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.item.inventory.property.SlotPos;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import me.runescapejon.CrazyFeet.CrazyFeet;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;

public class HelixGUICommand implements CommandExecutor {
	// this part is disabled due to creating null error making a better one
	// private Object plugins;
	Inventory invs = Inventory.builder().of(InventoryArchetypes.CHEST)
			.property(InventoryDimension.PROPERTY_NAME, new InventoryDimension(9, 4))
			.property(InventoryTitle.PROPERTY_NAME, InventoryTitle.of(
					Text.builder("§bH§ee§al§ci§2x §cC§ao§el§eo§cr §eP§2i§dc§bk§2e§ar").style(TextStyles.BOLD).build()))
			.build(CrazyFeet.getPlugin());

	@Listener
	public void onInventoryClick(ClickInventoryEvent event, @First Player player) {
		if (event.getTargetInventory().getName().get().equals(this.invs.getName().get())) {
			Transaction<ItemStackSnapshot> clickTransaction = event.getTransactions().get(0);
			ItemStack item = clickTransaction.getOriginal().createStack();
			if (item.getType().equals(ItemTypes.FIRE_CHARGE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyfire"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.REDSTONE_BLOCK)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyheart"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.NOTEBLOCK)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazynote"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.EMERALD)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazymagic"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.NETHER_STAR)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazywitch"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.ENDER_PEARL)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazypearl"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.COAL_BLOCK)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazysmoke"))
						.submit(CrazyFeet.getInstance());
			}
			// Head Particle here
			if (item.getType().equals(ItemTypes.FLINT_AND_STEEL)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyfirehead"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.REDSTONE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyhearthead"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.BOOK)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazymenu"))
						.submit(CrazyFeet.getInstance());
			}
			Optional<DyeColor> optionalDyeColor = item.get(Keys.DYE_COLOR);
			if (!optionalDyeColor.isPresent())
				return;
			DyeColor dyeColor = optionalDyeColor.get();
			if (dyeColor.equals(DyeColors.GREEN)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazygreenhelix"))
						.submit(CrazyFeet.getInstance());
			}
			Optional<DyeColor> optionalDyeColor1 = item.get(Keys.DYE_COLOR);
			if (!optionalDyeColor1.isPresent())
				return;
			DyeColor dyeColor1 = optionalDyeColor1.get();
			if (dyeColor1.equals(DyeColors.WHITE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazywhitehelix"))
						.submit(CrazyFeet.getInstance());
			}
			// just made this ItemStack so i can use Dye's with colors without
			// any problem's
			Optional<DyeColor> optionalDyeColorblue = item.get(Keys.DYE_COLOR);
			if (!optionalDyeColor1.isPresent())
				return;
			DyeColor dyeColorblue = optionalDyeColorblue.get();
			if (dyeColorblue.equals(DyeColors.LIGHT_BLUE)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazybluehelix"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.BOOK)) {
				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazymenu"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.BARRIER)) {
				player.playSound(SoundTypes.BLOCK_ANVIL_PLACE, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazydisable"))
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
		helixblue.offer(Keys.DISPLAY_NAME, Text.of(TextColors.BLUE, "CrazyBlueHelix!"));
		helixblue.offer(Keys.DYE_COLOR, DyeColors.LIGHT_BLUE);
		ItemStack white = ItemStack.of(ItemTypes.DYE, 1);
		white.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, "CrazyWhiteHelix!"));
		white.offer(Keys.DYE_COLOR, DyeColors.WHITE);
		ItemStack green = ItemStack.of(ItemTypes.DYE, 1);
		green.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GREEN, "CrazyGreenHelix!"));
		green.offer(Keys.DYE_COLOR, DyeColors.GREEN);
		ItemStack magic = ItemStack.of(ItemTypes.EMERALD, 1);
		magic.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyMagic!"));
		ItemStack witch = ItemStack.of(ItemTypes.NETHER_STAR, 1);
		witch.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyWitch!"));
		ItemStack pearl = ItemStack.of(ItemTypes.ENDER_PEARL, 1);
		pearl.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyPearl!"));
		ItemStack smoke = ItemStack.of(ItemTypes.COAL_BLOCK, 1);
		smoke.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "Crazysmoke!"));
		ItemStack smokeh = ItemStack.of(ItemTypes.TNT, 1);
		smokeh.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazysmokeHead!"));
		ItemStack fireH = ItemStack.of(ItemTypes.FLINT_AND_STEEL, 1);
		fireH.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyfireHead!"));
		ItemStack heartH = ItemStack.of(ItemTypes.REDSTONE, 1);
		heartH.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyHeartHead!"));
		ItemStack noteH = ItemStack.of(ItemTypes.JUKEBOX, 1);
		noteH.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyNoteHead!"));
		ItemStack magicH = ItemStack.of(ItemTypes.EMERALD_BLOCK, 1);
		magicH.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyMagicHead!"));
		ItemStack witchH = ItemStack.of(ItemTypes.SOUL_SAND, 1);
		witchH.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyWitchHead!"));

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
		invs.query(new SlotPos(0, 0)).set(bordergreen);
		invs.query(new SlotPos(1, 0)).set(borderred);
		invs.query(new SlotPos(2, 0)).set(borderwhite);
		invs.query(new SlotPos(3, 0)).set(borderpurple);
		invs.query(new SlotPos(4, 0)).set(borderpink);
		invs.query(new SlotPos(5, 0)).set(bordergray);
		invs.query(new SlotPos(6, 0)).set(borderpink);
		invs.query(new SlotPos(7, 0)).set(bordergreen);
		invs.query(new SlotPos(8, 0)).set(borderred);
		invs.query(new SlotPos(0, 3)).set(borderpurple);
		invs.query(new SlotPos(1, 3)).set(borderwhite);
		invs.query(new SlotPos(2, 3)).set(bordergreen);
		invs.query(new SlotPos(3, 3)).set(borderred);
		invs.query(new SlotPos(4, 3)).set(borderblue);
		invs.query(new SlotPos(5, 3)).set(borderpurple);
		invs.query(new SlotPos(6, 3)).set(borderwhite);
		invs.query(new SlotPos(7, 3)).set(borderblue);
		invs.query(new SlotPos(8, 1)).set(bordergray);
		invs.query(new SlotPos(0, 1)).set(borderpink);
		invs.query(new SlotPos(8, 1)).set(borderblue);
		invs.query(new SlotPos(0, 2)).set(borderred);
		invs.query(new SlotPos(8, 2)).set(borderpink);
		invs.query(new SlotPos(0, 3)).set(cdisable);
		invs.query(new SlotPos(8, 3)).set(menu);
		invs.query(new SlotPos(1, 1)).set(helixblue);
		invs.query(new SlotPos(2, 1)).set(white);
		invs.query(new SlotPos(3, 1)).set(green);
		// invs.query(new SlotPos(3, 1)).set(note);
		// invs.query(new SlotPos(4, 1)).set(magic);
		// invs.query(new SlotPos(5, 1)).set(witch);
		// invs.query(new SlotPos(6, 1)).set(pearl);
		// invs.query(new SlotPos(7, 1)).set(smoke);
		// invs.query(new SlotPos(1, 2)).set(fireH);
		// invs.query(new SlotPos(2, 2)).set(heartH);
		// invs.query(new SlotPos(3, 2)).set(noteH);
		// invs.query(new SlotPos(4, 2)).set(magicH);
		// invs.query(new SlotPos(5, 2)).set(witchH);
		// invs.query(new SlotPos(6, 2)).set(pearlH);
		// invs.query(new SlotPos(7, 2)).set(smokeh);
		player.sendMessage(LanguageUtils.getText("pleaseSelectCrazyParticle"));
		player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
		return CommandResult.success();
	}
}
