package me.runescapejon.CrazyFeet.Commands;

import java.util.ArrayList;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyWitchCommands implements CommandExecutor  {
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cWitch = CrazyFeet.CrazyWitch;

		if (src instanceof Player) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazywitch")) {
				if(cWitch.contains(player)) {
					cWitch.remove(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), " You have disabled your Witch Particles"));
					return CommandResult.success();
				} else {
					cWitch.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA, " You have enabled your Witch particles"));
					return CommandResult.success();
				}
			}
		}
		return CommandResult.success();
	}
}
