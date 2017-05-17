package me.runescapejon.CrazyFeet.Commands.Auto;

import java.util.Optional;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyAutoFire implements CommandExecutor {

	private CrazyFeet p;

	public CommandResult execute(CommandSource sender, CommandContext args) {
		Optional<Player> target = args.getOne("target");
		// Optional<String> targets = args.<String>getOne("targets");
		// TODO: rewrite this what below xD
		TextColor yellow = TextColors.YELLOW;
		TextColor red = TextColors.RED;

		// same here bukkit if(args.length < 1) {
		// if(sender instanceof Player) {
		if (!target.isPresent()) {
			Player player = (Player) sender;
			if (player.hasPermission("CrazyFeet.crazyfire.autofire")) {
				if (p.getAFirePlayers().contains(player.getName())) {
					p.getAFirePlayers().remove(player);
					p.getAFirePlayers().saveAutoFirePlayers();
					player.sendMessage(Text.of(Text.of(yellow + "You will no longer have " + red + "CrazyFire " + yellow
							+ "enabled when joining!")));
					return CommandResult.success();
				} else {
					p.getAFirePlayers().add(player);
					p.getAFirePlayers().saveAutoFirePlayers();
					player.sendMessage(Text
							.of(yellow + "You will now have " + red + "CrazyFire " + yellow + "enabled when joining!"));
					return CommandResult.success();
				}
			}
			// bukkit crap } else if(args.length == 1) {

		}
		return CommandResult.success();
	}
}
