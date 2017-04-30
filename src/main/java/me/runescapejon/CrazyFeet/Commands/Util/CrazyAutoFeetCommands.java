package me.runescapejon.CrazyFeet.Commands.Util;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class CrazyAutoFeetCommands implements CommandExecutor {
	public CommandResult execute(CommandSource sender, CommandContext args) throws CommandException {

		sender.sendMessage(Text.of(TextColors.YELLOW, "CrazyFeet automatic modes:"));
		sender.sendMessage(
				Text.of(TextColors.YELLOW, "These allow you to have the CrazyFeet modes enabled when joining!"));
		sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautofire", TextColors.YELLOW,
				" - Automatic CrazyFire on server join!"));
		sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautoheart", TextColors.YELLOW,
				" - Automatic CrazyHeart on server join!"));
		sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautosmoke", TextColors.YELLOW,
				" - Automatic CrazySmoke on server join!"));
		sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautomagic", TextColors.YELLOW,
				" - Automatic CrazyMagic on server join!"));
		sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautopearl", TextColors.YELLOW,
				" - Automatic CrazyPearl on server join!"));
		sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautonote", TextColors.YELLOW,
				" - Automatic CrazyNote on server join!"));
		sender.sendMessage(Text.of(TextColors.YELLOW, "-", TextColors.GREEN, " /crazyautowitch", TextColors.YELLOW,
				" - Automatic CrazyWitch on server join!"));
		return CommandResult.success();
	}
}
