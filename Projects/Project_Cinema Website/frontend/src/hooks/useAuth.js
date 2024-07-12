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
        } catch (error) {
            console.log('user not found');
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
    // const register = () => {

    // }

    const value = useMemo(
        () => ({
            user,
            setUser,
            login,
            logout,
        }),
        [user]
    );
    return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export const useAuth = () => {
    return useContext(AuthContext);
};