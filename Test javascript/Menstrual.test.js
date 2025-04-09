
const MenstrualMethod = require('./MenstrualMethod');
test('MenstrualMethod', () => {
    const menstrual = new MenstrualMethod(28, 5, '2023/10/01');


    expect(menstrual.getNextPeriodDays()).toBe('10/29/2023');
    expect(menstrual.getNextOvulation()).toBe('11/12/2023');
    expect(menstrual.getFertilityPeriod()).toBe('11/08/2023 - 11/12/2023');
    expect(menstrual.getNextFlowDays()).toBe('10/29/2023 - 11/03/2023');
    expect(menstrual.getNextPreOvulation()).toBe('10/29/2023 - 11/11/2023');
    expect(menstrual.getEndOfNextCycle()).toBe('11/25/2023');
    expect(menstrual.getNextPostOvulation()).toBe('11/13/2023 - 11/25/2023');
    expect(menstrual.getSafeDay()).toBe('10/29/2023 - 11/05/2023');
    expect(menstrual.getPostOvulationSafeDay()).toBe('11/14/2023 - 11/25/2023');

});