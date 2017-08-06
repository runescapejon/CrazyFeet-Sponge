package me.runescapejon.CrazyFeet.Commands.Util;

import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

public class CrazyFeetAdminCmd implements CommandExecutor {

	public CommandResult execute(CommandSource sender, CommandContext args) throws CommandException {
		// >.> lazy i know
		final TextColor red = TextColors.RED;
		final TextColor yellow = TextColors.YELLOW;
		final TextColor green = TextColors.GREEN;
		LanguageUtils.getTextList("crazyFeetAdminCommands").forEach(sender::sendMessage);
		// sender.sendMessage(Text.of(yellow, "-", green, " /crazydisable *",
		// yellow, " - Turn off everyone online's CrazyFeet modes!"));
		// sender.sendMessage(Text.of(yellow, "-", green, " /crazyautodisable
		// <target>", yellow, " - Turn off all automatic CrazyFeet modes on
		// target player!"));
		// sender.sendMessage(Text.of(yellow, "-", green, " /crazyautodisable
		// *", yellow, " - Turn off everyone online's CrazyFeet modes!"));
		return CommandResult.success();
	}
}