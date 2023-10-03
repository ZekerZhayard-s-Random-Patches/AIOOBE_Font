
var ASMAPI = Java.type("net.minecraftforge.coremod.api.ASMAPI");
var Opcodes = Java.type("org.objectweb.asm.Opcodes");
var InsnNode = Java.type("org.objectweb.asm.tree.InsnNode");
var MethodInsnNode = Java.type("org.objectweb.asm.tree.MethodInsnNode");

function initializeCoreMod() {
    return {
        "Font_<init>": {
            "target": {
                "type": "METHOD",
                "class": "net/minecraft/client/gui/fonts/Font",
                "methodName": "<init>",
                "methodDesc": "(Lnet/minecraft/client/renderer/texture/TextureManager;Lnet/minecraft/util/ResourceLocation;)V"
            },
            "transformer": function (mn) {
                var insnList = mn.instructions.toArray();
                for (var i = 0; i < insnList.length; i++) {
                    var node = insnList[i];
                    if (node.getOpcode() === Opcodes.PUTFIELD && node.owner.equals("net/minecraft/client/gui/fonts/Font") && node.name.equals(ASMAPI.mapField("field_211195_g")) && node.desc.equals("Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;")) {
                        mn.instructions.insertBefore(node, new InsnNode(Opcodes.POP));
                        mn.instructions.insertBefore(node, new MethodInsnNode(Opcodes.INVOKESTATIC, "io/github/zekerzhayard/aioobe_font/Int2ObjectConcurrentHashMap", "create", "()Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", false));
                    }
                }
                return mn;
            }
        }
    }
}
