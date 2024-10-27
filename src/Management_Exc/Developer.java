package Management_Exc;

public class    Developer extends Employee {
    private Manager projectManager;

    public Developer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Manager getProjectManager() {
        return projectManager;
    }

    /**
     * TODO the implementation
     * @param projectManager to be added as project manager
     * @throws IllegalStateException when this developer already has a project manager
     */
    protected void setProjectManager(Manager projectManager){
        if (this.projectManager != null)
            throw new IllegalStateException(this.getName()+ " already has a manager: " + this.projectManager.getName());
        this.projectManager = projectManager;
    }

    public void removePM() {
        this.projectManager = null;
    }

    @Override
    public void birthday() {
        super.birthday();
        if (projectManager != null) {
            projectManager.giveRaise(this, this.getSalary()*0.05);
        }
    }

    @Override
    public void performTask() {
        System.out.println(getName() + " is coding");
    }

    @Override
    public String toString() {
        if (projectManager != null) {
            return super.toString() + " [" + projectManager.getName() + "]";
        }
        return super.toString();
    }
}
