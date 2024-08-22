import React from 'react';
import { Routes, Route } from 'react-router-dom';
import { AuthProvider } from './hooks/useAuth'; // Ensure this path is correct

import HomePage from './pages/home/HomePage';
import FoodSelectionPage from './pages/food-selection/FoodSelectionPage';
import MovieListPage from './pages/movie-list/MovieListPage';
import MoviesPage from './pages/movies/MoviesPage';
import PaymentPage from './pages/payment/PaymentPage';
import PromotionListPage from './pages/promotion-list/PromotionListPage';
import SeatSelectionPage from './pages/seat-selection/SeatSelectionPage';
import TicketConfirmPage from './pages/ticket-confirm/TicketConfirmPage';
import AboutUsPage from './pages/about-us/AboutUsPage';
import AdminPage from './pages/admin/AdminPage';
import LoginPage from './pages/login/LoginPage';
import CinemaIntroPage from './pages/cinema-intro/CinemaIntroPage';
import CinemaListPage from './pages/cinema-list/CinemaListPage';
import ExperienceIntroPage from './pages/experience-intro/ExperienceIntroPage';
import ExperienceListPage from './pages/experience-list/ExperienceListPage';
import MovieIntroPage from './pages/movie-intro/MovieIntroPage';
import PromotionIntroPage from './pages/promotion-intro/PromotionIntroPage';

import Layout from './components/Layout';
import NoPage from './components/NoPage';

import { ProtectedRoute } from './components/ProtectedRoute';
import RegisterPage from './pages/register/RegisterPage';
import ProfilePage from './pages/profile/ProfilePage';
import TngPage from './pages/payment/TngPage';



function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route path="/" element={<Layout />}>

          <Route index path="" element={<HomePage />} />
          <Route path="login-page" element={<LoginPage />} />
          <Route path="register-page" element={<RegisterPage />} />
          {/* forget password */}
          <Route path="*" element={<NoPage />} />

          {/* Protected routes */}
          <Route path="/secret/" element={<ProtectedRoute />}>
            <Route path="profile-page" element={<ProfilePage />} />
            <Route path="movie-list-page" element={<MovieListPage />} />
            <Route path="movie-intro-page" element={<MovieIntroPage />} />
            <Route path="movies-page" element={<MoviesPage />} />
            <Route path="seat-selection-page" element={<SeatSelectionPage />} />
            <Route path="food-selection-page" element={<FoodSelectionPage />} />
            <Route path="payment-page" element={<PaymentPage />} />
            <Route path="tng-page" element={<TngPage />} />
            <Route path="cinema-list-page" element={<CinemaListPage />} />
            <Route path="cinema-intro-page" element={<CinemaIntroPage />} />
            <Route path="about-us-page" element={<AboutUsPage />} />

            {/* <Route path="promotion-list-page" element={<PromotionListPage />} /> */}
            {/* <Route path="promotion-intro-page" element={<PromotionIntroPage />} /> */}
            <Route path="ticket-confirm-page" element={<TicketConfirmPage />} />
            {/* <Route path="admin-page" element={<AdminPage />} /> */}
            {/* <Route path="experience-list-page" element={<ExperienceListPage />} /> */}
            {/* <Route path="experience-intro-page" element={<ExperienceIntroPage />} /> */}

            {/* Add more protected components as needed */}
            <Route path="*" element={<NoPage />} />
          </Route>

        </Route>
      </Routes>
    </AuthProvider>
  );
}

export default App;
