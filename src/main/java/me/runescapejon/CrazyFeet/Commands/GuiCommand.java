package me.runescapejon.CrazyFeet.Commands;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
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
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class GuiCommand implements CommandExecutor {
	private Object plugins;
	Inventory invs = Inventory.builder().of(InventoryArchetypes.CHEST)
			.property(InventoryDimension.PROPERTY_NAM, new InventoryDimension(9, 4))
			.property(InventoryTitle.PROPERTY_NAME,
					InventoryTitle.of(Text.builder("CrazyFeet").color(TextColors.DARK_RED).style(TextStyles.BOLD).build()))
			.build(this.plugins);

	@Listener
	public void onInventoryClick(ClickInventoryEvent event, @First Player player) {
		if (event.getTargetInventory().getName().get().equals(this.invs.getName().get())) {
			//event.setCancelled(true);
			Transaction<ItemStackSnapshot> clickTransaction = event.getTransactions().get(0);
			ItemStack item = clickTransaction.getOriginal().createStack();
			if (item.getItem().equals(ItemTypes.FIRE_CHARGE)) {
         	//use this way so like that if they have permission to command or not.
					Sponge.getCommandManager().process(player, "crazyfire");
					// cFire.add(player);
					// player.sendMessage(Text.of(TextColors.GOLD,
					// player.getName(), TextColors.AQUA,
					// " You have enabled your fire particles"));
				}
			if (item.getItem().equals(ItemTypes.REDSTONE_BLOCK)) {
						Sponge.getCommandManager().process(player, "crazyheart");
					}
			if (item.getItem().equals(ItemTypes.NOTEBLOCK)) {
				Sponge.getCommandManager().process(player, "crazynote");;
			}
			if (item.getItem().equals(ItemTypes.EMERALD)) {
				Sponge.getCommandManager().process(player, "crazymagic");
			}
			if (item.getItem().equals(ItemTypes.NETHER_STAR)) {
				Sponge.getCommandManager().process(player, "crazywitch");
			}
			if (item.getItem().equals(ItemTypes.ENDER_PEARL)) {
				Sponge.getCommandManager().process(player, "crazypearl");
			}
			if (item.getItem().equals(ItemTypes.COAL_BLOCK)) {
				Sponge.getCommandManager().process(player, "crazysmoke");
			}
			//Head Particle here
			if (item.getItem().equals(ItemTypes.FLINT_AND_STEEL)) {
				Sponge.getCommandManager().process(player, "crazyfirehead");
			}
			if (item.getItem().equals(ItemTypes.REDSTONE)) {
				Sponge.getCommandManager().process(player, "crazyhearthead");
			}
			if (item.getItem().equals(ItemTypes.JUKEBOX)) {
				Sponge.getCommandManager().process(player, "crazynotehead");
			}
			if (item.getItem().equals(ItemTypes.EMERALD_BLOCK)) {
				Sponge.getCommandManager().process(player, "crazymagichead");
			}
			if (item.getItem().equals(ItemTypes.SOUL_SAND)) {
				Sponge.getCommandManager().process(player, "crazywitchhead");
			}
			if (item.getItem().equals(ItemTypes.ENDER_EYE)) {
				Sponge.getCommandManager().process(player, "crazypearlhead");
			}
			if (item.getItem().equals(ItemTypes.TNT)) {
				Sponge.getCommandManager().process(player, "crazysmokehead");
			}
			event.setCancelled(true);
			}
		}

	//this will fix the bug that drop items off of guis
	 @Listener
	 public void DropEvent(ClickInventoryEvent.Drop event) {
		 if (event.getTargetInventory().getName().get().equals(this.invs.getName().get())) {
			 event.setCancelled(true);
		 }
	 }

	public CommandResult execute(CommandSource src, CommandContext ctx) throws CommandException {
		Player player = (Player) src;
		ItemStack fire = ItemStack.of(ItemTypes.FIRE_CHARGE, 1);
		 fire.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyFire!"));
			ItemStack heart = ItemStack.of(ItemTypes.REDSTONE_BLOCK, 1);
			 heart.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyHeart!"));
				ItemStack note = ItemStack.of(ItemTypes.NOTEBLOCK, 1);
				 note.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyNote!"));
					ItemStack magic = ItemStack.of(ItemTypes.EMERALD, 1);
					 magic.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyMagic!"));
						ItemStack witch = ItemStack.of(ItemTypes.NETHER_STAR, 1);
						 witch.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyWitch!"));
							ItemStack pearl = ItemStack.of(ItemTypes.ENDER_PEARL, 1);
							 pearl.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyPearl!"));
								ItemStack smoke = ItemStack.of(ItemTypes.COAL_BLOCK, 1);
								 smoke.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "Crazysmoke!"));
									ItemStack border = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
									border.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GOLD, "Please Chose your particle mode!"));
									border.offer(Keys.DYE_COLOR, DyeColors.GRAY);
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
												ItemStack pearlH = ItemStack.of(ItemTypes.ENDER_EYE, 1);
												pearlH.offer(Keys.DISPLAY_NAME, Text.of(TextColors.RED, "CrazyPearlHead!"));
		player.openInventory(invs, Cause.of(NamedCause.of(player.getName(), player)));
		invs.query(new SlotPos(0, 0)).set(border);
		invs.query(new SlotPos(1, 0)).set(border);
		invs.query(new SlotPos(2, 0)).set(border);
		invs.query(new SlotPos(3, 0)).set(border);
		invs.query(new SlotPos(4, 0)).set(border);
		invs.query(new SlotPos(5, 0)).set(border);
		invs.query(new SlotPos(6, 0)).set(border);
		invs.query(new SlotPos(7, 0)).set(border);
		invs.query(new SlotPos(8, 0)).set(border);
		invs.query(new SlotPos(0, 3)).set(border);
		invs.query(new SlotPos(1, 3)).set(border);
		invs.query(new SlotPos(2, 3)).set(border);
		invs.query(new SlotPos(3, 3)).set(border);
		invs.query(new SlotPos(4, 3)).set(border);
		invs.query(new SlotPos(5, 3)).set(border);
		invs.query(new SlotPos(6, 3)).set(border);
		invs.query(new SlotPos(7, 3)).set(border);
		invs.query(new SlotPos(8, 3)).set(border);
		invs.query(new SlotPos(8, 2)).set(border);
		invs.query(new SlotPos(1, 1)).set(fire);
		invs.query(new SlotPos(2, 1)).set(heart);
		invs.query(new SlotPos(3, 1)).set(note);
		invs.query(new SlotPos(4, 1)).set(magic);
		invs.query(new SlotPos(5, 1)).set(witch);
		invs.query(new SlotPos(6, 1)).set(pearl);
		invs.query(new SlotPos(7, 1)).set(smoke);
		invs.query(new SlotPos(8, 1)).set(border);
		invs.query(new SlotPos(0, 1)).set(border);
		invs.query(new SlotPos(1, 2)).set(fireH);
		invs.query(new SlotPos(2, 2)).set(heartH);
		invs.query(new SlotPos(3, 2)).set(noteH);
		invs.query(new SlotPos(4, 2)).set(magicH);
		invs.query(new SlotPos(5, 2)).set(witchH);
		invs.query(new SlotPos(6, 2)).set(pearlH);
		invs.query(new SlotPos(7, 2)).set(smokeh);
		invs.query(new SlotPos(8, 1)).set(border);
		invs.query(new SlotPos(0, 2)).set(border);
		player.sendMessage(Text.of(TextColors.AQUA, "Please Select a Crazy Particle!"));
		player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
		return CommandResult.success();
	}
}
