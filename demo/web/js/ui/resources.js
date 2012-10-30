WeekstaatResourceImpl = function ($resource) {
    return $resource('rest/weekstaten/:jaar/:weeknummer', {}, {
        get:{method:'GET', params:{}, isArray:true},
        getWeekstaat:{method:'GET', params:{jaar:'jaar', weeknummer:'weeknummer'}},
        save:{method:'PUT', params:{jaar:'jaar', weeknummer:'weeknummer'}}
    });
};