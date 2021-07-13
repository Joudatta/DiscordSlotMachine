import commands.Slots;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {

    public static String prefix = "!";
    public static String token = "ODQ3OTY5MjcwNjc5NDcwMTIw.YLFy7A.5tFXLj_RBGI8rZ14Yevd9oX2tw4";

    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault(token).build();
        jda.addEventListener(new Slots());
    }

}
