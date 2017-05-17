package me.runescapejon.CrazyFeet.Commands.head;

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

public class CrazyFireHeadCommand implements CommandExecutor {
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cFireh = CrazyFeet.crazyFireHead;
		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyfeet.crazyfirehead")) {
				if (cFireh.contains(player)) {
					cFireh.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your Fire Particles on your head"));
					return CommandResult.success();
				} else {
					cFireh.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your fire particles on your head"));
					return CommandResult.success();
				}
			}
		}

		else if (src.hasPermission("CrazyFeet.crazyfireheadother")) {
			Player targ = target.get();

			if (cFireh.contains(targ)) {
				cFireh.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyFireHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyFireHead has been disabled!"));
				return CommandResult.success();
			} else {
				cFireh.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyFireHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyFireHead!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
