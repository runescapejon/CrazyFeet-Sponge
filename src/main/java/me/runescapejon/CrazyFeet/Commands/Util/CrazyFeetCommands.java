package me.runescapejon.CrazyFeet.Commands.Util;

import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

public class CrazyFeetCommands implements CommandExecutor {

	@SuppressWarnings("unchecked")
	@Override
	public CommandResult execute(CommandSource sender, CommandContext args) throws CommandException {
		LanguageUtils.getTextList("crazyFeetCommands").forEach(sender::sendMessage);
		return CommandResult.success();
	}
}