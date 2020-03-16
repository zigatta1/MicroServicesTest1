import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DBServiceA {

    Logger logger = LoggerFactory.getLogger(DBServiceA.class);

    public String getData(int id) {
        logger.debug("id {}", id);
        String resultData = "resultData";
        logger.debug("resultData {}", resultData);
        return resultData;
    }
}
