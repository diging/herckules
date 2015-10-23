<div ng-controller="projectController">
	<ul>
    <li ng-repeat="project in projects">
      <span>{{project.projectName}}</span>
      <p>{{project.description}}</p>
    </li>
  </ul>
</div>