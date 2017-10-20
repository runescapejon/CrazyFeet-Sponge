package me.runescapejon.CrazyFeet.Commands;

import me.runescapejon.CrazyFeet.CrazyFeet;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

public class CrazyFeetReloadCommand implements CommandExecutor {

	@SuppressWarnings("unchecked")
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		CrazyFeet.getInstance().getLanguageConfig().reload();
		src.sendMessage(LanguageUtils.getText("crazyFeetReloaded"));
		return CommandResult.success();
	}
}
