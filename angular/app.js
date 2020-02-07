var app = angular.module("timezoneApp", ["ngRoute"]);
app.controller("CountryController", ['$scope', "CountryService", function($scope, CountryService){

function drawMap() {
	var data = google.visualization.arrayToDataTable(CountryService.getSavedCountries());
    $scope.SelectedCountry = "";
    $scope.SelectedTimeZone = "";
    $scope.TimeZoneList = [];

    var options = {
        dataMode: 'regions',
        width: 1200,
        height: 600,
        region: 'world',
        resolution: 'countries',
        legend: 'none',
        enableRegionInteractivity: 'true'
    };
    $scope.setCountryName = function(countryName){
      $scope.SelectedCountry = countryName;
      $scope.$apply();
    }
    $scope.setDefaultTimeZone = function (timeZone){
      $scope.SelectedTimeZone = timeZone;
      $scope.$apply();
    }

    var container = document.getElementById('regions_div');
    var chart = new google.visualization.GeoChart(container);
    
    $scope.myClickHandler = function (){
        var selection = chart.getSelection();
        var message = '';
		
      for (var i = 0; i < selection.length; i++) {
          var item = selection[i];
          var countryName = data.wg[item.row].c[0].v;
          var numTimeZones = data.wg[item.row].c[1].v;
          var defaultTimeZone = data.wg[item.row].c[2].v;

          if(item.row != null)
          {
            message += "Country: " + countryName;
            message += "\nNumber of Time Zones: " + numTimeZones;
            message += "\nDefault Time Zones: " + defaultTimeZone;
          }
      }
		
      if (message == '') {
          message = 'nothing';
      }
      $scope.setCountryName(countryName);
      $scope.setDefaultTimeZone(defaultTimeZone);
      //alert( message);
    }
    
    google.visualization.events.addListener(chart, 'select', $scope.myClickHandler);
    
    chart.draw(data, options);

    $scope.submitCountry = function() {
      alert("Form has been submitted")
    }

    $scope.resetForm = function() {
      alert("Form has been reset");
    }

}
google.load('visualization', '1', {packages: ['geochart'], callback: drawMap});

}]);
	
//Mock service provider
app.config(function($provide){
  $provide.factory('CountryService', function($q) {
    var countries =     
    [
      ['Country', 'numTimeZones', 'defaultTimeZone'],
      ['Germany', 200, 1],
      ['US', 300, 1],
      ['Brazil', 400, 1],
      ['Canada', 500, 1],
      ['France', 600, 1],
      ['Russia', 700, 1]
	  ];
	  
    return{
      //get current list of countries
      getSavedCountries: function(){
        return countries;
      },
      //get all countries with timezone data
      getAll: function(val){
        return this.getCountries();
      },
      //set default timezone on country
      setTimeZone: function(index, timezone){
        return this.getCountries();
      },
      //Called to get list of countries
      getCountries: function(){
        var deferred = $q.defer();
        deferred.resolve(countries);
        return deferred.promise;
      },
      setCountry: function(){
        
      }
    }
  });
});