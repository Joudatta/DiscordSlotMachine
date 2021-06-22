package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ServerInfo extends Command {
    public ServerInfo() {
        super.name = "serverinfo";
        super.aliases = new String[]{"server", "helpme"};
        super.help = "Gives information about the server";
    }

    @Override
    protected void execute(CommandEvent event) {
//        event.reply("hi");
    }
}
