package model;

public class CreateListBuilder {
    private CreateList createbodybodyList;

    private CreateListBuilder(){
        createbodybodyList = new CreateList();
    }
    public static CreateListBuilder aBodyList(){
        return new CreateListBuilder();
    }
    public CreateList getCreatebodybodyList() {
        return createbodybodyList;
    }
    public void setCreatebodybodyList(final CreateList createbodybodyList) {
        this.createbodybodyList = createbodybodyList;
    }

    public CreateList build(){
        return createbodybodyList;
    }



}
