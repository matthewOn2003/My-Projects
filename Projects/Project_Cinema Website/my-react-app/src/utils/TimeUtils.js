class TimeUtils {

    // Function to get hours in 24-hour format
    static getHH_24(date) {
        return date.getHours().toString().padStart(2, '0');
    }

    // Function to get hours and minutes in 24-hour format
    static getHHMM_24(date) {
        const hours = date.getHours().toString().padStart(2, '0');
        const minutes = date.getMinutes().toString().padStart(2, '0');
        return `${hours}:${minutes}`;
    }

    // Function to get hours, minutes, and seconds in 24-hour format
    static getHHMMSS_24(date) {
        const hours = date.getHours().toString().padStart(2, '0');
        const minutes = date.getMinutes().toString().padStart(2, '0');
        const seconds = date.getSeconds().toString().padStart(2, '0');
        return `${hours}:${minutes}:${seconds}`;
    }

    // Function to get hours in 12-hour format
    static getHH_12(date) {
        const hours = date.getHours() % 12 || 12;
        return hours.toString().padStart(2, '0');
    }

    // Function to get hours and minutes in 12-hour format
    static getHHMM_12(date) {
        const hours = date.getHours() % 12 || 12;
        const minutes = date.getMinutes().toString().padStart(2, '0');
        return `${hours}:${minutes}`;
    }

    // Function to get hours, minutes, and seconds in 12-hour format
    static getHHMMSS_12(date) {
        const hours = date.getHours() % 12 || 12;
        const minutes = date.getMinutes().toString().padStart(2, '0');
        const seconds = date.getSeconds().toString().padStart(2, '0');
        const period = date.getHours() < 12 ? 'AM' : 'PM';
        return `${hours}:${minutes}:${seconds} ${period}`;
    }


}
export default TimeUtils