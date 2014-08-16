import play.*;
import play.data.format.*;
import play.data.format.Formatters.*;
import java.util.Locale;
import java.text.ParseException;

import models.*;

public class Global extends GlobalSettings {

    public void onStart(Application app) {
        Formatters.register(PostTag.class, new SimpleFormatter<PostTag>() {
            @Override
            public PostTag parse(String tagId, Locale l) throws ParseException {
                Tag tag = Tag.findById(Long.valueOf(tagId));
                PostTag postTag = new PostTag();
                postTag.setTag(tag);
                return postTag;
            }

            @Override
            public String print(PostTag postTag, Locale l) {
                return String.valueOf(postTag.getTag().getId());
            }
        });
    }

    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

}