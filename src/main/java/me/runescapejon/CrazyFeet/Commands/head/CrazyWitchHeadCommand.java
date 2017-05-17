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

public class CrazyWitchHeadCommand implements CommandExecutor {
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cWitchHead = CrazyFeet.crazyWitchHead;

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazywitchhead")) {
				if (cWitchHead.contains(player)) {
					cWitchHead.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your Witch Particles"));
					return CommandResult.success();
				} else {
					cWitchHead.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your Witch particles"));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazywitchheadother")) {
			Player targ = target.get();

			if (cWitchHead.contains(targ)) {
				cWitchHead.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyWitch!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyWitch has been disabled!"));
				return CommandResult.success();
			} else {
				cWitchHead.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyWitch!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyWitch!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
