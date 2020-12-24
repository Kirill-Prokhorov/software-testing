package ru.stqa.software_testing.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.software_testing.mantis.model.Issue;
import ru.stqa.software_testing.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {

  private final ApplicationManager app;

  public SoapHelper(ApplicationManager app){

    this.app = app;
  }

  public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    ProjectData[] projects = mc.mc_projects_get_user_accessible(app.getProperty("mantis.soap.adminLogin")
            , app.getProperty("mantis.soap.adminPassword"));
    return Arrays.asList(projects).stream()
            .map((p) -> new Project().withId(p.getId().intValue()).withName(p.getName())).collect(Collectors.toSet());
  }

  private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
    MantisConnectPortType mc = new MantisConnectLocator()
            .getMantisConnectPort(new URL(app.getProperty("mantis.soap.url")));
    return mc;
  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    String[] categories = mc.mc_project_get_categories(app.getProperty("mantis.soap.adminLogin")
            , app.getProperty("mantis.soap.adminPassword"), BigInteger.valueOf(issue.getProject().getId()));
    IssueData issueDate = new IssueData();
    issueDate.setSummary(issue.getSummary());
    issueDate.setDescription(issue.getDescription());
    issueDate.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
    issueDate.setCategory(categories[0]);
    BigInteger issueId = mc.mc_issue_add(app.getProperty("mantis.soap.adminLogin")
            , app.getProperty("mantis.soap.adminPassword"), issueDate);
    IssueData createdIssueData = mc.mc_issue_get(app.getProperty("mantis.soap.adminLogin")
            , app.getProperty("mantis.soap.adminPassword"), issueId);

    return new Issue().withSummary(createdIssueData.getSummary()).withDescription(createdIssueData.getDescription())
                             .withId(createdIssueData.getId().intValue()).withProject(new Project()
                                        .withId(createdIssueData.getProject().getId().intValue())
                                                      .withName(createdIssueData.getProject().getName()));
  }

  public int issueId() throws MalformedURLException, ServiceException, RemoteException {

    MantisConnectPortType mc = getMantisConnect();
    BigInteger projectId = mc.mc_project_get_id_from_name(app.getProperty("mantis.soap.adminLogin")
            , app.getProperty("mantis.soap.adminPassword"), "mantis");
    IssueData[] issues = mc.mc_project_get_issues(app.getProperty("mantis.soap.adminLogin")
            , app.getProperty("mantis.soap.adminPassword"), projectId, BigInteger.valueOf(1), BigInteger.valueOf(0));
    Random random = new Random();
    return Arrays.asList(issues).get(random.nextInt(issues.length)).getId().intValue();

  }

  public int issueStatus(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    return mc.mc_issue_get(app.getProperty("mantis.soap.adminLogin"), app.getProperty("mantis.soap.adminPassword"),
            BigInteger.valueOf(issueId)).getStatus().getId().intValue();
  }
}
