class MenstrualMethod{

    constructor(periodDays, flowDays, firstDayOfLastPeriod) {
        this.periodDays = periodDays;
        this.flowDays = flowDays;
        this.firstDayOfLastPeriod = firstDayOfLastPeriod
    }

    formatDate(date) {

        if (!(date instanceof Date) || isNaN(date)) {
            throw new Error("Invalid date passed to formatDate: " + date);
        }
        return new Intl.DateTimeFormat('en-US', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit'
        }).format(date);
    }

    setPeriodDays(days) {
        this.periodDays = days;
    }

    setLastPeriodDate(input) {
        this.firstDayOfLastPeriod = input;
    }

    setFlowDays(flow) {
        this.flowDays = flow;
    }

    getNextPeriodDays() {
        const first = new Date(this.firstDayOfLastPeriod);
        first.setDate(first.getDate() + this.periodDays);
        return this.formatDate(first);

    }
    getNextOvulation() {
        const first = new Date(this.firstDayOfLastPeriod);
        first.setDate(first.getDate() + this.periodDays)
        let ovulationDate   = new Date(first);

        if (this.periodDays > 33) {
            ovulationDate.setDate(ovulationDate.getDate() + 21);
        }
        else if (this.periodDays > 28) {
            ovulationDate.setDate(ovulationDate.getDate() + 16);
        }
        else if (this.periodDays > 24) {
            ovulationDate.setDate(ovulationDate.getDate() + 14);
        }
        else  {
            ovulationDate.setDate(ovulationDate.getDate() + 9);
        }
        return this.formatDate(ovulationDate)
    }

    getFertilityPeriod() {
        const first = new Date(this.firstDayOfLastPeriod);
        first.setDate(first.getDate() + this.periodDays + 5);
        const fertilityStart= new Date(first);

        if (this.periodDays > 28) {
            fertilityStart.setDate(fertilityStart.getDate() + this.periodDays + 11);
        }
        else if(this.periodDays > 24) {
            fertilityStart.setDate(fertilityStart.getDate() + this.periodDays + 9);
        }
        else{
            fertilityStart.setDate(fertilityStart.getDate() + this.periodDays + 5);
        }
        const fertilityEnd = this.getNextOvulation();
        return `${this.formatDate(fertilityStart)} - ${fertilityEnd}`;
    }


    getNextFlowDays() {
        const  first = new Date(this.firstDayOfLastPeriod);
        let nextFlowDays = new Date(first);
        nextFlowDays.setDate(nextFlowDays.getDate() + this.periodDays + this.flowDays);
        let period  = this.getNextPeriodDays();
        return `${period} - ${this.formatDate(nextFlowDays)}`
    }

    getNextPreOvulation() {
        const ovulationDate = this.getNextOvulation();
        const first = new Date(ovulationDate);
        first.setDate(first.getDate() - 1);
        let period = this.getNextPeriodDays();

        return `${period} - ${this.formatDate(first)}`
    }

    getEndOfNextCycle() {
        const first = new Date(this.firstDayOfLastPeriod);
        first.setDate(first.getDate() + periodDays + periodDays - 1);
        return this.formatDate(first);

    }

    getNextPostOvulation() {
        const endOfNextCycle = this.getEndOfNextCycle();
        const first = new Date(this.firstDayOfLastPeriod);
        let nextOvulation = new Date(first);
        nextOvulation.setDate(nextOvulation.getDate() + this.periodDays + 10);
        if (periodDays > 24) {
            nextOvulation.setDate(first.getDate() + this.periodDays + 15);
        }
        else if (periodDays > 28) {
            nextOvulation.setDate(nextOvulation.getDate() + this.periodDays + 17);
        }
        else if (periodDays > 33) {
            nextOvulation.setDate(nextOvulation.getDate() + this.periodDays + 22);
        }
        return `${this.formatDate(nextOvulation)} - ${endOfNextCycle}`

    }

    getSafeDay() {
        const first = new Date(this.firstDayOfLastPeriod);
        const nextFlowDays = new Date(first);
        nextFlowDays.setDate(first.getDate() + this.periodDays + this.flowDays + 2);
        const period = this.getNextPeriodDays();
        return `${period} - ${this.formatDate(nextFlowDays)}`;
    }

    getPostOvulationSafeDay() {
        const ovulationDate = this.getNextOvulation();
        const safeStart = new Date(ovulationDate);
        safeStart.setDate(safeStart.getDate() + 2);
        const safeEnd = this.getEndOfNextCycle();
        return `${this.formatDate(safeStart)} - ${safeEnd}`;
    }
}


module.exports = MenstrualMethod;