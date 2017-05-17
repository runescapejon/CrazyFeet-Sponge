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

public class CrazyNoteHeadCommand implements CommandExecutor {
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cNoteHead = CrazyFeet.crazyNoteHead;

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazynotehead")) {
				if (cNoteHead.contains(player)) {
					cNoteHead.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your Note Particles on your head!"));
					return CommandResult.success();
				} else {
					cNoteHead.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your Note particles on your head"));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazynoteheadother")) {
			Player targ = target.get();

			if (cNoteHead.contains(targ)) {
				cNoteHead.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyNoteHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyNoteHead has been disabled!"));
				return CommandResult.success();
			} else {
				cNoteHead.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyNoteHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyNoteHead!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}