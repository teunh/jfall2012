TimeManagementServiceImpl = function(WeekstaatResource) {
    return {
        getWeekstaten: function (callback) {
            WeekstaatResource.get(callback);
        },

        getWeekstaat: function(weeknummer) {
            return WeekstaatResource.getWeekstaat({jaar: new Date().getFullYear(), weeknummer: weeknummer});
        },

        getHuidigeWeekstaat: function () {
            return WeekstaatResource.getWeekstaat({jaar: new Date().getFullYear(), weeknummer: new Date().getWeek()});
        },

        saveRegistratie: function (weeknummer, registratie) {
            WeekstaatResource.save({
                jaar: new Date().getFullYear(),
                weeknummer: weeknummer
            }, registratie);
        }
    }
};
