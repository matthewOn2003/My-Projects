// File: Showtime.ts
import { Movie } from './Movie';
import { Cinema } from './Cinema';
import { Hall } from './Hall';

export interface Showtime {
    showtimeId: number;
    movie: Movie;
    cinema: Cinema;
    hall: Hall;
    showDate: string;
    startTime: string;
    endTime: string;
    createdAt: string;
    updatedAt: string;
}
