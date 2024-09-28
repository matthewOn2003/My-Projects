module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'jsdom', // 使用 jsdom 作为环境
  transform: {
    '^.+\\.tsx?$': 'ts-jest',
  },
  moduleFileExtensions: ['ts', 'tsx', 'js', 'jsx', 'json', 'node'],
  transformIgnorePatterns: [
    '/node_modules/(?!(axios)/)', // 确保 axios 不被忽略
  ],
};
