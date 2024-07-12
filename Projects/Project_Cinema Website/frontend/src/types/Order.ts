// File: Order.ts
import { Food } from './Food';
import { Seat } from './Seat';

export interface Order {
    orderNumber: number;
    userId: number;
    showtimeId: number;
    transactionDate: string;
    totalAmount: string;
    foods?: Food[];
    seats?: Seat[];
    createdAt: string;
    updatedAt: string;
}
