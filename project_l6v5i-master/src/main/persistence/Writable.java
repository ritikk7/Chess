package persistence;

import org.json.JSONArray;

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONArray toJson();
}
