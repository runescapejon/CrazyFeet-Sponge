package me.runescapejon.CrazyFeet.Commands;

import java.util.ArrayList;
import java.util.Optional;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyFireCommands implements CommandExecutor {

	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cFire = CrazyFeet.crazyFire;
		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazyfire")) {
				if (cFire.contains(player)) {
					cFire.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your fire particles"));
					return CommandResult.success();
				} else {
					cFire.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your fire particles"));
					return CommandResult.success();
				}
			}
		}

		else if (src.hasPermission("CrazyFeet.crazyfireother")) {
			Player targ = target.get();

			if (cFire.contains(targ)) {
				cFire.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyFire!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyFire has been disabled!"));
				return CommandResult.success();
			} else {
				cFire.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyFire!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyFire!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
