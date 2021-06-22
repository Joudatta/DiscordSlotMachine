package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Calculate extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        String[] msgSent = e.getMessage().getContentRaw().split(" ");

        if (msgSent[0].equalsIgnoreCase("!calculate") && msgSent.length == 1) {
            e.getChannel().sendMessage("To use this command, type (without brackets): !calculate [add/sub] [firstNumber] [secondNumber]").queue();
        }

        else if (msgSent[0].equalsIgnoreCase("!calculate") && msgSent[1].equalsIgnoreCase("add")) {
            int num1 = Integer.parseInt(msgSent[2]);
            int num2 = Integer.parseInt(msgSent[3]);
            e.getChannel().sendMessage("Here is the result: " + (num1 + num2)).queue();
        }
        else if (msgSent[0].equalsIgnoreCase("!calculate") && msgSent[1].equalsIgnoreCase("sub")) {
            int num1 = Integer.parseInt(msgSent[2]);
            int num2 = Integer.parseInt(msgSent[3]);
            e.getChannel().sendMessage("Here is the result: " + (num1 - num2)).queue();
        }
    }
}
