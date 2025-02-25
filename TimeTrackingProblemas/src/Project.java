import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project extends Component{
    private List<Component> childrenProject=new ArrayList<>();
    public Project(String tagName) {
        super(tagName);
    }
    public Project(String tagName, Project parentProject){
        super(tagName,parentProject);
    }

    @Override
    void updateFinalDate(LocalDateTime newFinalDate) {
        setDateFinal(newFinalDate);
        if(this.tagName!="root"){
            parentProject.setDateFinal(newFinalDate);
        }
    }

    @Override
    void updateDuration(Duration newDuration) {
        setDuration(newDuration);
        if(this.tagName!="root"){
            if(this.parentProject.duration!=null){
                parentProject.setDuration(this.duration.plusSeconds(parentProject.duration.getSeconds()));
            }
            else{
                parentProject.setDuration(newDuration);
            }

        }

    }

    @Override
    protected void acceptVisitor(Visitor v) {
        v.visitProject(this);
        for(Component i :childrenProject){
            i.acceptVisitor(v);
        }
    }

    public List<Component> getChildrenProject() {
        return childrenProject;
    }

    public void setChildrenProject(List<Component> childrenProject) {
        this.childrenProject = childrenProject;
    }

    protected void addComponent(Component component){
        childrenProject.add(component);
        component.setParentProject(this);
        component.setTagParentProject(this.tagName);

    }


}
