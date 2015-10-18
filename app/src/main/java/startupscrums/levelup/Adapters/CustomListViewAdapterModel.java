package startupscrums.levelup.Adapters;

// Data Model for the listview
public class CustomListViewAdapterModel {
    public String name, description, objectId;

    public CustomListViewAdapterModel(String name, String description, String objectId){
        this.name = name;
        this.description = description;
        this.objectId = objectId;
    }

    public String getName(){
        return name;
    }
    public String getObjectId(){
        return objectId;
    }
}
