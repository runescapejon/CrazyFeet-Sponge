package me.runescapejon.CrazyFeet.Commands.Auto;

import java.util.Optional;

import me.runescapejon.CrazyFeet.utils.LanguageUtils;
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
				if (CrazyFeet.getInstance().getAFirePlayers().contains(player.getName())) {
					CrazyFeet.getInstance().getAFirePlayers().remove(player);
					CrazyFeet.getInstance().getAFirePlayers().saveAutoFirePlayers();
					player.sendMessage(LanguageUtils.getText("crazyAutoFireDisabled"));
					return CommandResult.success();
				} else {
					CrazyFeet.getInstance().getAFirePlayers().add(player);
					CrazyFeet.getInstance().getAFirePlayers().saveAutoFirePlayers();
					player.sendMessage(LanguageUtils.getText("crazyAutoFireEnabled"));
					return CommandResult.success();
				}
			}
			// bukkit crap } else if(args.length == 1) {

		}
		return CommandResult.success();
	}
}
