package me.runescapejon.CrazyFeet.Commands.Util;

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

		sender.sendMessage(Text.of(red, "~ Admin menu ~"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazynote <target>", yellow, " - Toggle Crazynote on target player!"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazyfire <target>", yellow, " - Toggle CrazyFire on target player!"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazysmoke <target>", yellow, " - Toggle CrazySmoke on target player!"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazypearl <target>", yellow, " - Toggle CrazyPearl on target player!"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazymagic <target>", yellow, " - Toggle CrazyMagic on target player!"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazywitch <target>", yellow, " - Toggle Crazywitch on target player!"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazyheart <target>", yellow, " - Toggle Crazyheart on target player!"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazy<mode>head <target>", yellow, " - Toggle Crazy<mode>Head on target player"));
		sender.sendMessage(
				Text.of(yellow, "-", green, " /crazycheck <target>", yellow, " - Check target's CrazyFeet modes!"));
		sender.sendMessage(Text.of(yellow, "-", green, " /crazydisable <target>", yellow,
				" - Turn off all CrazyFeet modes on target player!"));
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