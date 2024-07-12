class DateTimeUtils {
    constructor(dateTimeStr) {
        this.date = new Date(dateTimeStr);
    }

    // Helper function to ensure double digits
    pad(num) {
        return num < 10 ? '0' + num : num;
    }


    getDayOfWeek() {
        const days_arr = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
        return days_arr[this.date.getDay()]; // Sunday - Saturday : 0 - 6
    }

    //
    getYear() {
        return this.date.getFullYear();
    }

    getMonth() {
        const month_arr = ['Jan', 'Feb', 'Mac', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        return month_arr[this.date.getMonth()]; // Return short form of the month

    }

    getDayOfMonth() {
        return this.pad(this.date.getDate());
    }

    getDate() {
        const year = this.getYear();
        const month = this.getMonth();
        const day = this.getDayOfMonth();
        return `${year}-${month}-${day}`;
    }

    getDateOption() {
        const dow = this.getDayOfWeek();
        const dom = this.getDayOfMonth();
        const month = this.getMonth();
        return `${dow}-${dom}-${month}`;
    }


    //
    getHour() {
        return this.pad(this.date.getHours());
    }

    getMinutes() {
        return this.pad(this.date.getMinutes());
    }

    getSeconds() {
        return this.pad(this.date.getSeconds());
    }

    getTime() {
        const hours = this.getHour();
        const minutes = this.getMinutes();
        const seconds = this.getSeconds();
        return `${hours}:${minutes}:${seconds}`;
    }
}

export default DateTimeUtils;;