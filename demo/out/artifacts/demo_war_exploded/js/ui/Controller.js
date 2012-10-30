WeekstaatController = function ($scope, $routeParams, TimeManagementService) {
    $scope.weekstaat = TimeManagementService.getWeekstaat($routeParams.weeknummer);
}

AppController = function ($rootScope, $scope, $locale, $location, $route, TimeManagementService) {
    $scope.omschrijvingFilter = "";
    $scope.huidigeWeekstaat;
    $scope.nieuweActiviteit = "";
    $scope.nieuweUren = 0;
    $scope.huidigWeeknummer = new Date().getWeek();

    TimeManagementService.getWeekstaten(function (weekstaten) {
        $scope.weekstaten = weekstaten;
        var currentWeek = new Date().getWeek();
        $.each(weekstaten, function () {
            if (this.weeknummer === currentWeek) {
                $scope.huidigeWeekstaat = this;
                return false; //break;
            }
        });
    });

    $scope.setNieuweActiviteit = function (tijdregistratie) {
        $scope.nieuweActiviteit = tijdregistratie.code;
    }

    $scope.berekenTotaal = function (project) {
        var totaal = 0;
        $.each(project.tijdRegistraties, function () {
            totaal += this.uren;
        });
        return totaal;
    };

    $scope.geefHuidigeWeekstaat = function () {
        $scope.huidigeWeekstaat = TimeManagementService.getHuidigeWeekstaat();
    }

    $scope.saveRegistratie = function () {
        var nieuweRegistratie = {
            uren:$scope.nieuweUren,
            code:$scope.nieuweActiviteit
        }
        $scope.huidigeWeekstaat.tijdRegistraties.push(nieuweRegistratie);
        $scope.nieuweUren = 0;
        $scope.nieuweActiviteit = "";
        TimeManagementService.saveRegistratie($scope.huidigeWeekstaat.weeknummer, nieuweRegistratie);
    }

    $scope.toonWeekstaat = function (weekstaat) {
        $location.path("/weekstaat/" + weekstaat.weeknummer);
    }


};
