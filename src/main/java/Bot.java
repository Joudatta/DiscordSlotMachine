import commands.Slots;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {

    public static String prefix = "!";
    public static String token = ""; //I removed the actual token because that would lead to possible exploits

    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault(token).build();
        jda.addEventListener(new Slots());
    }

}
