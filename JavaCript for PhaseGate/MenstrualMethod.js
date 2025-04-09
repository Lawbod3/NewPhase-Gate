class menstrualMethod{

    constructor(periodDays, flowDays, firstDayOfLastPeriod) {
        this.periodDays = periodDays;
        this.flowDays = flowDays;
        this.firstDayOfLastPeriod = firstDayOfLastPeriod
    }

    formatDate(date) {
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
       const nextPeriodDays = String(first.setDate(first.getDate() + this.periodDays));
       return this.formatDate(nextPeriodDays);

    }
    getNextOvulation() {
        const first = new Date(this.firstDayOfLastPeriod);
        const nextPeriodDays = first.setDate(first.getDate() + this.periodDays)
         let ovulationDate   = String(nextPeriodDays.setDate(nextPeriodDays.getDate() + 9));
        if (this.periodDays > 24) {
            ovulationDate =  String(nextPeriodDays.setDate(nextPeriodDays.getDate() + 14));
        }
        else if (this.periodDays > 28) {
            ovulationDate =  String(nextPeriodDays.setDate(nextPeriodDays.getDate() + 16));
        }
        else if (this.periodDays > 33) {
            ovulationDate =  String(nextPeriodDays.setDate(nextPeriodDays.getDate() + 21));
        }
        return this.formatDate(ovulationDate)
    }

    getFertilityPeriod() {
        const first = new Date(this.firstDayOfLastPeriod);
        let fertilityStart = first.setDate(first.getDate() + this.periodDays + 5);
        const fertilityEnd = this.getNextOvulation();

        if(this.periodDays > 24) {
             fertilityStart = first.setDate(first.getDate() + this.periodDays + 9) ;
        }
        else if (this.periodDays > 28) {
            fertilityStart = first.setDate(first.getDate() + this.periodDays + 11);
        }
        return `${this.formatDate(fertilityStart)} - ${fertilityEnd}`;
    }


    getNextFlowDays() {
        const  first = new Date(this.firstDayOfLastPeriod);
        let nextFlowDays = first.setDate(first.getDate() + this.periodDays + this.flowDays);
        let period  = this.getNextPeriodDays();
        return `${period} - ${this.formatDate(nextFlowDays)}`
    }

    getNextPreOvulation() {
        const ovulationDate = this.getNextOvulation();
        const first = new Date(ovulationDate);
        let nextPreOvulation = first.setDate(first.getDate() - 1);
        let period = this.getNextPeriodDays();

        return `${period} - ${this.formatDate(nextPreOvulation)}`
    }

    getEndOfNextCycle() {
        const first = new Date(this.firstDayOfLastPeriod);
        let endPeriod = first.setDate(first.getDate() + periodDays + periodDays - 1);
        return this.formatDate(endPeriod);

    }

    getNextPostOvulation() {
        const endOfNextCycle = this.getEndOfNextCycle();
        const first = new Date(this.firstDayOfLastPeriod);
        let nextOvulation = first.setDate(first.getDate() + this.periodDays + 10);
        if (periodDays > 24) {
            nextOvulation = first.setDate(first.getDate() + this.periodDays + 15);
        }
        else if (periodDays > 28) {
            nextOvulation = first.setDate(first.getDate() + this.periodDays + 17);
        }
        else if (periodDays > 33) {
            nextOvulation = first.setDate(first.getDate() + this.periodDays + 22);
        }
        return `${this.formatDate(nextOvulation)} - ${endOfNextCycle}`

    }


}