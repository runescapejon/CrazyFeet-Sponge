package me.runescapejon.CrazyFeet.Commands.Util;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.command.spec.CommandExecutor;

public class CrazyFeetCommands implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource sender, CommandContext args) throws CommandException {

		 {
			sender.sendMessage(Text.of(TextColors.YELLOW, "Availiable commands:"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "CrazyFeet modes:"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyfire", TextColors.YELLOW, " - Walk on fire!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyheart", TextColors.YELLOW, " - Walk on Hearts!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazynote", TextColors.YELLOW, " - Walk on notes!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazysmoke", TextColors.YELLOW, " - Walk on smoke!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazymagic", TextColors.YELLOW, " - Walk on magic dust!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazypearl", TextColors.YELLOW, " - Walk on pearls!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazywitch", TextColors.YELLOW, " - Walk on witches magic!!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "CrazyFeet help:"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyfeet", TextColors.YELLOW, " - Display this menu."));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautofeet", TextColors.YELLOW, " - Display this menu."));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautohead", TextColors.YELLOW, " - Display this menu."));
			sender.sendMessage(Text
					.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazycheck", TextColors.YELLOW, " - Check what CrazyFeet modes are active!"));
			sender.sendMessage(Text
					.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazydisable", TextColors.YELLOW, " - Disable all of your CrazyFeet modes!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautodisable", TextColors.YELLOW, " - Disable all of your automatic CrazyFeet modes!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautocheck", TextColors.YELLOW, " - Check what automatic CrazyFeet modes are active!"));
			sender.sendMessage(Text
					.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyfeet admin", TextColors.YELLOW, " - Displays CrazyFeet admin commands!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyhead", TextColors.YELLOW, " - Displays CrazyHead Menu!"));
			sender.sendMessage(Text.of(TextColors.YELLOW, "All CrazyFeet mode commands toggle on and off."));
			return CommandResult.success();
			}
	}
}