import { useState } from "react";
import AuthCard from "../../components/AuthCard";
import { useAuth } from "../../hooks/useAuth";
import LoginForm from "./LoginForm";

function LoginPage() {

    const [formState, setFormState] = useState({
        username: '',
        password: '',
    });

    const { login } = useAuth();

    // const handleLogin = async (e) => {
    //     console.log('handleLogin');
    //     e.preventDefault();

    //     const isValidUsername = (username) => {
    //         const usernameRegex = /^[a-z][a-z0-9]{5,9}$/;
    //         return usernameRegex.test(username);
    //     };

    //     const isValidPassword = (password) => {
    //         const passwordRegex = /^[^\s]{6,}$/;
    //         return passwordRegex.test(password);
    //     };

    //     if (!isValidUsername(username)) {
    //         alert('Invalid username. It must be 6-10 characters long, start with a letter, and contain only lowercase letters and numbers.');
    //         return;
    //     }

    //     if (!isValidPassword(password)) {
    //         alert('Invalid password. It must be at least 6 characters long and contain no spaces.');
    //         return;
    //     }

    //     await login({ username, password });

    // };

    return (
        <AuthCard title="Login">
            <LoginForm title="Login with Username" formState={formState} setFormState={setFormState} />
        </AuthCard>
        // <div className="AuthPage d-flex align-items-center" style={{ height: '100vh' }}>
        //     <div>
        //         <form onSubmit={handleLogin}>
        //             <div>
        //                 <label htmlFor="username">Username:</label>
        //                 <input
        //                     id="username"
        //                     type="text"
        //                     value={username}
        //                     onChange={(e) => setUsername(e.target.value)}
        //                 />
        //             </div>
        //             <div>
        //                 <label htmlFor="password">Password:</label>
        //                 <input
        //                     id="password"
        //                     type="password"
        //                     value={password}
        //                     onChange={(e) => setPassword(e.target.value)}
        //                 />
        //             </div>
        //             <button type="submit">Login</button>
        //         </form>
        //     </div>
        // </div>
    );
}

export default LoginPage;
