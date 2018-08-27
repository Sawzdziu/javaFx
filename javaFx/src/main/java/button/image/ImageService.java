package button.image;

import config.ImageEnum;
import javafx.scene.image.ImageView;

/**
 * Created by piotrsa on 22/08/18.
 */
public class ImageService {

    private static final Integer ICON_SIZE = 20;

    public static ImageView prepareImage(ImageEnum imageEnum) {
        ImageView image = new ImageView(imageEnum.getPath());
        image.setFitHeight(ICON_SIZE);
        image.setFitWidth(ICON_SIZE);
        return image;
    }
}
