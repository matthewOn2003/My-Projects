import { createContext, useContext, useMemo } from "react";
import { useNavigate } from "react-router-dom";
import { useLocalStorage } from "./useLocalStorage";
import UserService from "../services/UserService";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useLocalStorage("user", null);
    const navigate = useNavigate();


    // call this function when you want to authenticate the user
    const login = async (data) => {

        try {
            const response = await UserService.getUserByCredentials(data.username, data.password);
            setUser(response);
            navigate("/secret/profile-page");
            alert('Login Successful!');
        } catch (error) {
            alert('User do not exist. Please register an account first.');
            console.error(error);
        }

    };

    // call this function to sign out logged in user
    const logout = () => {
        // change status to active means user active now
        let updatedUser = user;
        updatedUser.status = 'INACTIVE';

        setUser(null);
        UserService.updateUserStatus(updatedUser.userId, 'INACTIVE');

        // navigate("/", { replace: true });
        navigate("/login-page");
    };


    //
    const register = async (formState) => {
        alert('register...');
        const user = {
            username: formState.username,
            email: formState.email,
            password: formState.password,
            fullName: formState.fullName,
            role: 'USER',
            status: 'INACTIVE',
            // profilePicture,
            phoneNumber: formState.phoneNumber,
            birthDate: `${formState.birthDate} 00:00:00`,
            // lastLogin,
        }


        try {
            const response = await UserService.addUser(user);
            alert('Register Successful!')
            navigate("/login-page");
        } catch (error) {
            alert('Register Failed!');
            console.error(error);
        }


    }

    const value = useMemo(
        () => ({
            user,
            setUser,
            login,
            logout,
            register,
        }),
        [user]
    );
    return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export const useAuth = () => {
    return useContext(AuthContext);
};